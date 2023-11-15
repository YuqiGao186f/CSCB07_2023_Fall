package com.example.cscb07_2023_fall

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cscb07_2023_fall.databinding.FragmentStudentHomePageBinding

class StudentHomePage : Fragment() {

private var _binding: FragmentStudentHomePageBinding? = null
private val binding get() = _binding!!

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View {
        _binding = FragmentStudentHomePageBinding.inflate(inflater, container, false)
        return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnViewAnnouncements.setOnClickListener {
        findNavController().navigate(R.id.action_studentHomePage_to_announcementsPage)
        }

        binding.btnCheckQualifications.setOnClickListener {
        findNavController().navigate(R.id.action_studentHomePage_to_qualificationsPage)
        }

        binding.btnPostComplaint.setOnClickListener {
        findNavController().navigate(R.id.action_studentHomePage_to_complaintPage)
        }

        binding.btnRSVP.setOnClickListener {
        findNavController().navigate(R.id.action_studentHomePage_to_rsvpPage)
        }

        binding.btnCommentRateEvent.setOnClickListener {
        findNavController().navigate(R.id.action_studentHomePage_to_commentRatePage)
        }

        binding.btnLogOut.setOnClickListener {
        findNavController().navigate(R.id.action_studentHomePage_to_logout)
        }
        }

        override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        }
        }
